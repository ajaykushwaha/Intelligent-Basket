import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { HomePage } from  '../home/home'
import { AngularFirestore } from '@angular/fire/firestore';
import { Observable } from 'rxjs';
import { ToastController } from 'ionic-angular';
import * as $ from "jquery";
import { RegistrationPage } from '../registration/registration';


@IonicPage()
@Component({
  selector: 'page-welcome',
  templateUrl: 'welcome.html',
})
export class WelcomePage {
  otp: String="";
  mob : String = "";
  url: String = "";

  constructor(public db:AngularFirestore,
    public navCtrl: NavController, public navParams: NavParams,public alertCtrl: AlertController,public toastCtrl: ToastController) {
  }



  GoToRegistrationPage()
  {
  	this.navCtrl.setRoot(RegistrationPage);
  }

  presentToast(the_title:string) {
    const toast = this.toastCtrl.create({
      message: the_title,
      duration: 3000,
      position: 'top'
    });
    toast.present();
  }

 MyAlert(the_title:string,the_subTitle:string) {
    let alert = this.alertCtrl.create({
      title: the_title,
      subTitle: the_subTitle,
      buttons: ['close']
    });
    alert.present();
  }

  randomInt(min, max){
    return Math.floor(Math.random() * (max - min + 1)) + min;
 }

  validity()
  {
	if(/^[0-9]{10}$/.test(this.mob.valueOf()))
      {
        return true;
      }
      else
      {
        this.MyAlert('Mobile Number Error',"Enter a  proper and Non-Empty Mobile name");
      }  
       
    return false;
  }

  LoginUser() {
    if(this.validity())
    {
      
    this.otp = String(this.randomInt(100000, 999999));
    const prompt = this.alertCtrl.create({
      title: 'Verify OTP',
      message: "A six digit OTP has been sent to your mobile.Please enter your OTP",
      inputs: [
        {
          name: 'otp_input',
          placeholder: 'OTP',
          type:'number'
        },
      ],
      buttons: [
        {
          text: 'Cancel',
          handler: data => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Verify',
          handler: data => {
            if(data.otp_input.localeCompare(this.otp)==0)
            {
              this.navCtrl.setRoot(HomePage);
            }
            else
            {
              this.presentToast('Wrong One Time Password.');     
              return false;        
            }
          }
        }
      ]
    });
    prompt.present();

      console.log(this.otp.valueOf());
      this.url = "https://smsapi.engineeringtgr.com/send/?Mobile=7709790242&Password=THuD3nAE93Gm9RP&Key=riderZP6qKNbBGVMx7fQ&Message=Your_OTP_for_Login_in_Kmart_is_";
      this.url = this.url.concat(this.otp.valueOf().concat("&To=".concat(this.mob.valueOf())));
       $.ajax({
      url: this.url,
      method: "POST" 
      }).done(function(res){
         console.log(res);        
      }).fail(function(err){
         console.log(err); 
      });

    }
    
  }

}
