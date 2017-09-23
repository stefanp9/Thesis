import { Component, OnInit } from '@angular/core';
import { IDrugs } from 'app/drugs/drugs';
import { ActivatedRoute, Router } from '@angular/router';
import { DrugService } from 'app/drugs/drug.service';

@Component({
  selector: 'pm-drug-detail',
  templateUrl: './drug-detail.component.html',
  styleUrls: ['./drug-detail.component.css']
})
export class DrugDetailComponent implements OnInit {
    pageTitle: string ='Detalji o leku';
    errorMessage: string;
    drug: IDrugs;

  constructor(private _route: ActivatedRoute,
    private _router: Router,
    private _drugService: DrugService) { }

  ngOnInit() {
    let id = +this._route.snapshot.paramMap.get('id');
    this.getDrug(id);
  }

  getDrug(id: number) {
    this._drugService.getDrug(id).subscribe(
      drug => this.drug = drug,
      error => this.errorMessage = <any>error);
  }

  onBack(): void {
    this._router.navigate(['/drugs']);
  }

}
