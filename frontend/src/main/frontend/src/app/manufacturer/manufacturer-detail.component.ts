import { Component, OnInit } from '@angular/core';
import { IManuf } from './manufacturer';
import { ActivatedRoute, Router } from '@angular/router';
import { ManufacturerService } from './manufacturer.service';

@Component({
  selector: 'pm-manufacturer-detail',
  templateUrl: './manufacturer-detail.component.html',
  styleUrls: ['./manufacturer-detail.component.css']
})
export class ManufacturerDetailComponent implements OnInit {
  pageTitle: string ='Detalji proizvođača';
  errorMessage: string;
  manuf : IManuf;

  constructor(private _route: ActivatedRoute,
    private _router: Router,
    private _manufService: ManufacturerService) { }

  ngOnInit() {
    let id = +this._route.snapshot.paramMap.get('id');
    this.getManuf(id);

  }

  getManuf(id: number) {
    this._manufService.getManufacturer(id).subscribe(
      manuf => this.manuf = manuf,
      error => this.errorMessage = <any>error);
  }

  onBack(): void {
    this._router.navigate(['/manufacturers']);
  }

}
