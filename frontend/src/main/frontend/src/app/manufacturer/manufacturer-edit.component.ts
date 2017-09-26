import { Component, OnInit } from '@angular/core';
import { IManuf } from 'app/manufacturer/manufacturer';
import { Man } from 'app/manufacturer/manufacturer-edit';
import { ActivatedRoute, Router } from '@angular/router';
import { ManufacturerService } from 'app/manufacturer/manufacturer.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'pm-manufacturer-edit',
  templateUrl: './manufacturer-edit.component.html',
  styleUrls: ['./manufacturer-edit.component.css']
})
export class ManufacturerEditComponent implements OnInit {
  man : Man = new Man (0, '','','','','')
  pageTitle: string;
  private id : number;
  errorMessage: string;

  private subMans:Subscription;



  constructor(private manService:ManufacturerService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit() {
      this.subMans = this.route.params.subscribe(
        params => {
          let id = +params['id'];
          this.id=id;
          this.getMan(id);
        }
      )
         
  };

  getMan(id : number){

  }
  
  }




