import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { ModalController } from 'ionic-angular';
import { MapPage } from '../map/map';
import { Firebase } from '@ionic-native/firebase';
import { AngularFirestore } from '@angular/fire/firestore';

@Component({
  selector: 'page-cart',
  templateUrl: 'cart.html',
})


export class CartPage {

  ItemsInCart: string[][];	
  cart : string;
  constructor(public navCtrl: NavController, public navParams: NavParams,public modalCtrl: ModalController,private firebase: Firebase,private db:AngularFirestore) {
  	this.initializeItems();
  }

  showMap() {
    const modal = this.modalCtrl.create(MapPage);
    modal.present();
  }

  ionViewDidLoad() {
    this.db.collection('User_details').add({
      'First_name':"haha",
      'Last_name':"papa",
    });
  }
  initializeItems()
  {
  	this.ItemsInCart = [
     ['water','2litre','45'],
     ['onion','4kg','200'],
     ['potato','4kg','200'],
     ['yadayada','2kg','150'],
     ['pista','5kg','400'],
     ['guitar','1-piece','7500']
    ];
    this.cart = "unbilled";
  }
 
  removeItems(ev: any) {
     var str = ev.target.id;
     let x  = str.split(",")
     console.log(x[0]);
     this.ItemsInCart = this.ItemsInCart.filter(item =>item[0]!==x[0] && item[1]!==x[1] && item[2]!==x[2]);
    }  
}
