package com.example.android.BluetoothChat;

public class Car {

	public int x;
	public int y;
	public double rad;
	
	public Car(int x,int y){
		this.x = x;
		this.y = y;	
		this.rad = - Math.PI/2;
	}
	
	public void setPosition(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void setRad(double rad){
		this.rad = rad;
	}
	
	public int get_x(){
		return x;
	}
	
	public int get_y(){
		return y;
	}
	
	public int foward_x(int distance){
		int distance_x = 0;
		distance_x = (int) (distance * Math.cos(rad));
		this.x += distance_x;
		return x+distance_x;
	}
	
	public int foward_y(int distance){
		int distance_y = 0;
		distance_y = (int) (distance * Math.sin(rad));
		this.y += distance_y;
		return y+distance_y;
	}
	
	public int back_x(int distance){
		int distance_x = 0;
		distance_x = (int) (distance * Math.cos(rad));
		this.x -= distance_x;
		return x-distance_x;
	}
	
	public int back_y(int distance){
		int distance_y = 0;
		distance_y = (int) (distance * Math.sin(rad));
		this.y -= distance_y;
		return y-distance_y;
	}
	
}
