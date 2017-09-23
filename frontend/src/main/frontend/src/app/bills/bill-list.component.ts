import { Component, OnInit } from '@angular/core';
import { IBill } from './bill';
import { BillService } from './bill.service';

@Component({
  selector: 'pm-bill-list',
  templateUrl: './bill-list.component.html',
  styleUrls: ['./bill-list.component.css']
})
export class BillListComponent implements OnInit {
  pageTitle: string = 'Lista računa';
  errorMessage: string;

  _listFilter: string;
  get listFilter(): string {
      return this._listFilter;
  }
  set listFilter(value: string) {
    this._listFilter = value;
    this.filteredBills = this.listFilter ? this.performFilter(this.listFilter) : this.bills;
}
  filteredBills: IBill[];
  bills : IBill[] = [];

  constructor(private _billService : BillService) { }

  performFilter(filterBy: string): IBill[] {
    filterBy = filterBy.toLocaleLowerCase();
    return this.bills.filter((bill: IBill) =>
    bill.id.toLocaleString().toLocaleLowerCase().indexOf(filterBy) !== -1);
}
ngOnInit() : void {
    this._billService.getBills()
        .subscribe(bills => {
            this.bills = bills;
            this.filteredBills = this.bills;
        },
         error => this.errorMessage = <any>error);   
    
}

}
