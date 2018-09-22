import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { CartPage } from '../cart/cart'
import { ListPage } from '../list/list'
import { Storage } from '@ionic/storage';


@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  fname: String ;
  lname: String ;
  constructor(public navCtrl: NavController,private storage: Storage) {
    
  }

  ionViewDidLoad() {
    this.SetName();
  }

  SetName()
  {
    this.storage.get('fname').then((val) => {
      this.fname = val ;
      console.log(this.fname);
      document.getElementById('personName').innerHTML = this.fname.valueOf();
    });
    
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
