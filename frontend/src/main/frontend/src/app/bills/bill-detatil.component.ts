import { Component, OnInit } from '@angular/core';
import { IBill } from './bill';
import { ActivatedRoute, Router } from '@angular/router';
import { BillService } from './bill.service';
import { IBillItem } from './billItem';

@Component({
  selector: 'pm-bill-detatil',
  templateUrl: './bill-detatil.component.html',
  styleUrls: ['./bill-detatil.component.css']
})
export class BillDetatilComponent implements OnInit {
  pageTitle: string ='Detalji o računu';
  errorMessage: string;
  bill: IBill;
  item: IBillItem;

  constructor(private _route: ActivatedRoute,
    private _router: Router,
    private _billService : BillService) { }

    ngOnInit() {
      let id = +this._route.snapshot.paramMap.get('id');
      this.getBill(id);
    }

    getBill(id: number) {
      this._billService.getBill(id).subscribe(
        bill => this.bill =bill,
        error => this.errorMessage = <any>error);
    }
  
    onBack(): void {
      this._router.navigate(['/bills']);
    }

}
