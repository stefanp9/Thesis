import { NgModule } from '@angular/core';
import { ManufacturerListComponent } from './manufacturer-list.component';
import { ManufacturerDetailComponent } from './manufacturer-detail.component';
import { RouterModule } from '@angular/router';
import { ManufacturerService } from './manufacturer.service';
import { SharedModule } from './../shared/shared.module';
import { ManufacturerEditComponent } from './manufacturer-edit.component';

@NgModule({
  imports: [
    RouterModule.forChild([
      {path: 'manufacturers', component: ManufacturerListComponent },
      {path: 'manufacturers/:id', component: ManufacturerDetailComponent },
      {path: 'manufacturerEdit/:id', component : ManufacturerEditComponent }
    ]
    ),
    SharedModule
  ,
  ],
  declarations: [
    ManufacturerListComponent,
    ManufacturerDetailComponent,
    ManufacturerEditComponent
  ],
  providers: [ManufacturerService]
})
export class ManufacturerModule { }
