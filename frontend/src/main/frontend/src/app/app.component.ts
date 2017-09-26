import { Component } from '@angular/core';


@Component({
  selector: 'pm-root',
  template: `
  <div>
  <nav class='navbar navbar-default'>
      <div class='container-fluid'>
          <a class='navbar-brand'>{{pageTitle}}</a>
          <ul class='nav navbar-nav'>
              <li><a [routerLink]="['/welcome']">Home</a></li>
              <li><a [routerLink]="['/drugs']">LEKOVI</a></li>
              <li><a [routerLink]="['/manufacturers']">PROIZVOĐAČI</a></li>
              <li><a [routerLink]="['/bills']">RAČUNI</a></li>
              <li><a [routerLink]="['/drugEdit/0']">KREIRAJ RAČUN</a></li>
          </ul>
      </div>
  </nav>
  <div class='container'>
      <router-outlet></router-outlet>
  </div>
</div>
<script></script>
`
})
export class AppComponent {
  pageTitle: string = 'APOTEKA:Dobro došli ';
}
