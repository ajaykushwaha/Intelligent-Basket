import { Component } from '@angular/core';
import { IonicPage, NavController } from 'ionic-angular';
import { BarcodeScanner , BarcodeScannerOptions } from '@ionic-native/barcode-scanner';

@IonicPage()
@Component({
  selector: 'page-scan-for-card',
  templateUrl: 'scan-for-card.html',
})
export class ScanForCardPage {
  options: BarcodeScannerOptions;
  encodeText:string = '';
  encodeData:any = [];
  scanData:any = [];

   constructor(public navCtrl: NavController,public scanner:BarcodeScanner) {
   }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ScanForCardPage');
  }

  scan()
  {
    
    this.options = {
           prompt : 'Scan your Qrcode'
        };
    this.scanner.scan(this.options).then((data) => {
          this.scanData = data;
        },
      (err) =>{
        console.log('Error : ',err);
      })
	
  }
}
