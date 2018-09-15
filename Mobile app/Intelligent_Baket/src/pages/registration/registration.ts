import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { ScanForCardPage } from  '../scan-for-card/scan-for-card'

@IonicPage()
@Component({
  selector: 'page-registration',
  templateUrl: 'registration.html',
})
export class RegistrationPage {

  constructor(public navCtrl: NavController, public navParams: NavParams,public alertCtrl: AlertController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad RegistrationPage');
  }

  verifyOTP() {
    const prompt = this.alertCtrl.create({
      title: 'Verify OTP',
      message: "A six digit OTP has been sent to your mobile.Please enter your OTP",
      inputs: [
        {
          name: 'otp',
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
            this.navCtrl.setRoot(ScanForCardPage);
          }
        }
      ]
    });
    prompt.present();
  }
}
