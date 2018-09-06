import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';


@Component({
  selector: 'page-cart',
  templateUrl: 'cart.html',
})
export class CartPage {

  ItemsInCart: string[];	
  constructor(public navCtrl: NavController, public navParams: NavParams) {
  	this.initializeItems();
  }

  initializeItems()
  {
  	this.ItemsInCart = [
      'Amsterdam',
      'Bogota',
      'cata',
      'data',
      'maggie',
      'water'
    ];
  }
 
  removeItems(ev: any) {
     var closebtns = document.getElementById(ev.target.id);
     var str = closebtns.parentElement.textContent;
     str = str.substring(0,str.length - 1);
     //console.log(str);
    this.ItemsInCart = this.ItemsInCart.filter(item => item !== str);
    }  
}
