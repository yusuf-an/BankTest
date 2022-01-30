package com.challange.fileParser.entity;

public class User {

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


    private long id;

    private int coins;
    
    private String name;

    public User(long id,int coins,String name) {
        this.id = id;
        this.name = name;
        this.coins = coins;
    }
    
 }