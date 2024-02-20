package com.activitylifecycle.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Item implements Parcelable {

   int item_id;
   String item_name;
   int quantity;
   float price;

   public Item(int item_id, String item_name, int quantity, float price){
      this.item_id=item_id;
      this.item_name=item_name;
      this.quantity=quantity;
      this.price=price;
   }

   protected Item(Parcel in) {
      item_id = in.readInt();
      item_name = in.readString();
      quantity = in.readInt();
      price = in.readFloat();
   }

   public int getItem_id() {
      return item_id;
   }

   public String getItem_name() {
      return item_name;
   }

   public int getQuantity() {
      return quantity;
   }

   public float getPrice() {
      return price;
   }

   public void setQuantity(int quantity){
      this.quantity=quantity;
   }

   public static final Creator<Item> CREATOR = new Creator<Item>() {
      @Override
      public Item createFromParcel(Parcel in) {
         return new Item(in);
      }

      @Override
      public Item[] newArray(int size) {
         return new Item[size];
      }
   };

   @Override
   public int describeContents() {
      return 0;
   }

   @Override
   public void writeToParcel(@NonNull Parcel parcel, int i) {
      parcel.writeInt(item_id);
      parcel.writeString(item_name);
      parcel.writeInt(quantity);
      parcel.writeFloat(price);
   }

   @Override
   public String toString() {
      return "Item{" +
              "item_id=" + item_id +
              ", item_name='" + item_name + '\'' +
              ", quantity=" + quantity +
              ", price=" + price +
              '}';
   }
}
