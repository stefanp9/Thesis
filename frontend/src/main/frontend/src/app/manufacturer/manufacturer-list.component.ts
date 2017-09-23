import { Component, OnInit } from '@angular/core';
import { IManuf } from 'app/manufacturer/manufacturer';
import { ManufacturerService } from 'app/manufacturer/manufacturer.service';

@Component({
  selector: 'pm-manufacturer-list',
  templateUrl: './manufacturer-list.component.html',
  styleUrls: ['./manufacturer-list.component.css']
})
export class ManufacturerListComponent implements OnInit {
  pageTitle: string = 'Lista proizođača';
  errorMessage: string;

  _listFilter: string;
  get listFilter(): string {
      return this._listFilter;
  }
  set listFilter(value: string) {
    this._listFilter = value;
    this.filtredManufs = this.listFilter ? this.performFilter(this.listFilter) : this.manufs;
  }
  filtredManufs : IManuf[];
  manufs : IManuf[] = [];

  constructor(private _manufService : ManufacturerService) { }

  performFilter(filterBy: string): IManuf[] {
    filterBy = filterBy.toLocaleLowerCase();
    return this.manufs.filter((manuf: IManuf) =>
          manuf.name.toLocaleLowerCase().indexOf(filterBy) !== -1);
}

  ngOnInit(): void {
    this._manufService.getManufacturers()
    .subscribe(manufs => {
        this.manufs = manufs;
        this.filtredManufs = this.manufs;
    },
     error => this.errorMessage = <any>error);   

}

}
