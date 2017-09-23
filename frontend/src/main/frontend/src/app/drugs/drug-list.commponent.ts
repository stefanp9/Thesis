
import { Component, OnInit } from "@angular/core";
import { IDrugs } from "./drugs";
import { DrugService } from "./drug.service";

@Component({
    templateUrl: './drug-list.commponent.html',
    styleUrls: ['./drug-list.component.css']
})

export class DrugListComponent implements OnInit{
    pageTitle: string = 'Lista lekova';
    errorMessage: string;

    _listFilter: string;
    get listFilter(): string {
        return this._listFilter;
    }
    set listFilter(value: string) {
        this._listFilter = value;
        this.filteredDrugs = this.listFilter ? this.performFilter(this.listFilter) : this.drugs;
    }
    filteredDrugs: IDrugs[];
    drugs : IDrugs[] = [];

    constructor(private _drugService : DrugService) {
        
    }
    performFilter(filterBy: string): IDrugs[] {
        filterBy = filterBy.toLocaleLowerCase();
        return this.drugs.filter((drug: IDrugs) =>
              drug.name.toLocaleLowerCase().indexOf(filterBy) !== -1);
    }
    ngOnInit() : void {
        this._drugService.getDrugs()
            .subscribe(drugs => {
                this.drugs = drugs;
                this.filteredDrugs = this.drugs;
            },
             error => this.errorMessage = <any>error);   
        
    }
}