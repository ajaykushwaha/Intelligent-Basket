import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-bills',
  templateUrl: 'bills.html',
})
export class BillsPage {

  allBills: string[][];		
  constructor(public navCtrl: NavController, public navParams: NavParams) {
  	this.initBills();
  }

  initBills()
  {
  	this.allBills = [
     ['water','2litre','45'],
     ['onion','4kg','200'],
     ['potato','4kg','200'],
     ['yadayada','2kg','150'],
     ['pista','5kg','400'],
     ['guitar','1-piece','7500']
    ];
  }
  ionViewDidLoad() {
    console.log('ionViewDidLoad BillsPage');
  }

}
