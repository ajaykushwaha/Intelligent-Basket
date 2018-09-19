import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import * as $ from "jquery";
import { ToastController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  name : String = "";
  quant : String = "";
  price : String = "";
  disc: String = "";
  num: String = "";	
  script_url: String = "https://script.google.com/macros/s/AKfycbworQd_q690svUZntBOJ3fbkFvDXNmBDQJba7SnBilXchuS6b4/exec";

  constructor(public navCtrl: NavController,public toastCtrl: ToastController) {

  }

  presentToast(the_title:string) {
    const toast = this.toastCtrl.create({
      message: the_title,
      duration: 3000,
      position: 'top'
    });
    toast.present();
  }

  addProduct()
  {
  	 var url = this.script_url+"?callback=ctrlq&name="+this.name+"&quant="+this.quant+"&price="+this.price+"&disc="+this.disc+"&num="+this.num+"&action=insert";
  	console.log(url);

    var request = $.ajax({
      crossDomain: true,
      url: url ,
      method: "GET",
      dataType: "jsonp",
      success: data => {
                  
            }
    });
    this.name  = "";
    this.quant  = "";
    this.price  = "";
    this.disc = "";
    this.num = "";  
    this.presentToast('Item Added in List.')
  }


}
