import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { ScanForCardPage } from  '../scan-for-card/scan-for-card'
import { AngularFirestore } from '@angular/fire/firestore';
import { Observable } from 'rxjs';
import { ToastController } from 'ionic-angular';
import * as $ from "jquery";

@IonicPage()
@Component({
  selector: 'page-registration',
  templateUrl: 'registration.html',
})
export class RegistrationPage {
  fname : String = "";
  lname : String = "";
  mob : String = "";
  add1: String = "";
  add2: String = "";
  add3: String = "";
  otp: String="";
  url: String = "https://smsapi.engineeringtgr.com/send/?Mobile=7709790242&Password=THuD3nAE93Gm9RP&Key=riderZP6qKNbBGVMx7fQ&Message=Your OTP for Registration in Kmart is ";
  
  constructor(public db:AngularFirestore,
    public navCtrl: NavController, public navParams: NavParams,public alertCtrl: AlertController,public toastCtrl: ToastController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad RegistrationPage');
  }

  presentToast() {
    const toast = this.toastCtrl.create({
      message: 'Wrong One Time Password.',
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
    if(/[A-za-z]{1,}$/.test(this.fname.valueOf()))
    {
        if(/[A-za-z]{1,}$/.test(this.lname.valueOf()))
        {
            if(/^[0-9]{10}$/.test(this.mob.valueOf()))
              {
                 if(/.{1}$/.test(this.add1.valueOf()))
                {
                   return true; 
                }
                else
                {
                   this.MyAlert('Address Error',"Enter a  proper and Non-Empty Manditory First line of address");
                }  
              }
              else
              {
                this.MyAlert('Mobile Number Error',"Enter a  proper and Non-Empty Mobile name");
              }  
        }
        else
        {
           this.MyAlert('Last Name Error',"Enter a  proper and Non-Empty Last name");
        }
    }
    else
    {
      this.MyAlert('First Name Error',"Enter a  proper and Non-Empty First name");
    }  
    
    return false;
  }

  verifyOTP() {
    if(this.validity())
    {
      this.db.collection('User_details').add({
      'First_name':this.fname,
      'Last_name':this.lname,
      'Mobile':this.mob,
      'Add1':this.add1,
      'Add2':this.add2,
      'Add3':this.add3
      
    });
   
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
              this.navCtrl.setRoot(ScanForCardPage);
            }
            else
            {
              this.presentToast();     
              return false;        
            }
          }
        }
      ]
    });
    prompt.present();

      console.log(this.otp.valueOf());
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

