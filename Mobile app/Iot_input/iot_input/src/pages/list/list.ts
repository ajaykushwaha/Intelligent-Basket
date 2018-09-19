import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import * as $ from "jquery";
import { ToastController } from 'ionic-angular';

@Component({
  selector: 'page-list',
  templateUrl: 'list.html'
})
export class ListPage {
  
  script_url: String = "https://script.google.com/macros/s/AKfycbworQd_q690svUZntBOJ3fbkFvDXNmBDQJba7SnBilXchuS6b4/exec";
  obj:any = {};
  id: String = "";
  constructor(public navCtrl: NavController, public navParams: NavParams,public toastCtrl: ToastController) {
    this.getData();
  }

  presentToast(the_title:string) {
    const toast = this.toastCtrl.create({
      message: the_title,
      duration: 3000,
      position: 'top'
    });
    toast.present();
  } 

  addAllColumnHeaders(myList)
 {
     var columnSet = [];
     var headerTr$ = $('<tr/>');
 
     for (var i = 0 ; i < myList.length ; i++) {
         var rowHash = myList[i];
         for (var key in rowHash) {
             if ($.inArray(key, columnSet) == -1){
                 columnSet.push(key);
                 headerTr$.append($('<th/>').html(key));
             }
         }
     }
     $("#excelDataTable").append(headerTr$);
 
     return columnSet;
 }

 buildHtmlTable(myList) 
 {
     var columns = this.addAllColumnHeaders(myList);
 
     for (var i = 0 ; i < myList.length ; i++) {
         var row$ = $('<tr/>');
         for (var colIndex = 0 ; colIndex < columns.length ; colIndex++) {
             var cellValue = myList[i][columns[colIndex]];
 
             if (cellValue == null) { cellValue = ""; }
 
             row$.append($('<td/>').html(cellValue));
         }
         $("#excelDataTable").append(row$);
     }
 }

 getData()
 {
    var url = this.script_url+"?action=getData";
    console.log(url);

    var request = $.ajax({
      crossDomain: true,
      url: url ,
      method: "GET",
      dataType: "json",
      success: data=> {
                 this.obj = <JSON>data;
                 this.buildHtmlTable(this.obj);
            }
    });
 }

 delProduct()
 {
    var url = this.script_url+"?action=delete&id="+this.id;
    console.log(url);

    var request = $.ajax({
      crossDomain: true,
      url: url ,
      method: "GET",
      dataType: "json",
      success: data=> {}
    });
    this.id = "";  
    this.presentToast('Item Deleted in List.')


 }
}
