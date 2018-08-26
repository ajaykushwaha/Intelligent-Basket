import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { CartPage } from '../cart/cart'
import { ListPage } from '../list/list'



@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController) {

  }

  GoToCartPage()
  {

  	this.navCtrl.setRoot(CartPage);
  }

  GoToListPage()
  {

  	this.navCtrl.setRoot(ListPage);
  }
}
