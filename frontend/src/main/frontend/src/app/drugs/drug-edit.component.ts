import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Drug } from './drug-edit';
import { DrugService } from 'app/drugs/drug.service';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { IDrugs } from 'app/drugs/drugs';
import { ManufacturerService } from 'app/manufacturer/manufacturer.service';
import { IManuf } from 'app/manufacturer/manufacturer';

@Component({
  selector: 'pm-drug-edit',
  templateUrl: './drug-edit.component.html',
  styleUrls: ['./drug-edit.component.css']
})
export class DrugEditComponent implements OnInit {
  drug  = new Drug(0,'', 0 ,0, '0','0','0');
  forms = [];
  inns = [];
  mans : IManuf[] = [];
  errorMessage: string;
  pageTitle: string;
  hasSelectError1 = false;
  hasSelectError2 = false;
  hasSelectError3 = false;
  private id : number;
  

 // drug: IDrugs;

  private subForms: Subscription;
  private subDrug:Subscription;
  private subInns:Subscription;
  private subMans:Subscription;

  constructor(private _drugService:DrugService,
              private manService:ManufacturerService,
              private router: Router,
              private route: ActivatedRoute) {
               }

  validateSelect1(event){
    if (this.drug.drugForm === 'default')
        this.hasSelectError1 = true;
      else 
        this.hasSelectError1 = false;
  }
  validateSelect2(event){
    if (this.drug.drugInn === 'default')
        this.hasSelectError2 = true;
      else 
        this.hasSelectError2 = false;
  }
  validateSelect3(event){
    if (this.drug.drugManufacturer === 'default')
        this.hasSelectError3 = true;
      else 
        this.hasSelectError3 = false;
  }

  save(form : NgForm){
    if(this.id === 0) 
    this._drugService.postDrug(this.drug)
      .subscribe(
        data => this.onSaveComplete(data),
        err => this.onSaveError(err)
        ) 
      else 
        this._drugService.putDrug(this.drug, this.id)
          .subscribe(
            data => this.onUpdateComplete(data),
            err => this.onUpdateError(err)
            )
      }

    deleteDrug(){
      this._drugService.deleteDrug(this.drug, this.id)
          .subscribe(
            data => this.onDeleteComplete(data),
            err => this.onDeleteError(err)
            )
      }

  

  ngOnInit() {
    this.subForms = this._drugService.getForms()
    .subscribe(
      data => this.forms = data,
      err => console.log('error', err)
    );
    this.subForms = this._drugService.getInns()
    .subscribe(
      data => this.inns = data,
      err => console.log('error', err)
    );

    this.manService.getManufacturers()
    .subscribe(mans => {
        this.mans = mans;
    },
     error => this.errorMessage = <any>error);  

    this.subDrug = this.route.params.subscribe(
      params => {
          let id = +params['id'];
          this.id=id;
          this.getDrug(id);
      }
  ); 
  }

  getDrug(id: number): void {
    this._drugService.getOneDrug(id)
        .subscribe(
            (drug: IDrugs) => this.onProductRetrieved(drug),
            (error: any) => this.errorMessage = <any>error
        );
}

  onProductRetrieved(drug: IDrugs): void {
    this.drug = drug;
    if (this.drug.id === 0) {
      this.pageTitle = 'Dodaj Lek';
  } else {
      this.pageTitle = `Izmeni Lek: ${this.drug.name}`;
  }
}

  ngOnDestroy(): void {
    this.subForms.unsubscribe();
}
onSaveComplete(data): void {
    alert("Lek je uspesno unet");
    console.log(data);
    this.router.navigate(['/drugs']);
}
onSaveError(err):void{
  console.log(err)
  alert("Sistem nije zapamtio lek")
}
onUpdateComplete(data): void {
  alert("Podaci su uspešno izmenjeni" );
  console.log(data);
  this.router.navigate(['/drugs']);
}
onUpdateError(err):void{
  console.log(err)
  alert("Sistem ne može da zapamti izmene")
}
onDeleteComplete(data): void {
  alert("Sistem je obrisao lek" );
  console.log(data);
  this.router.navigate(['/drugs']);
}
onDeleteError(err):void{
  console.log(err)
  alert('Sistem ne može da obriše lek \n'
        +' Razlog: Lek se nalazi na nekom od racuna')
}


}
