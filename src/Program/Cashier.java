package Program;

import java.util.ArrayList;
import java.util.Scanner;

public class Cashier implements Payment {
	private String item, food, beverage;
	private int price, quantity;
	private String ordered;
	
	
	ArrayList<Cashier> listPack = new ArrayList<>();
	ArrayList<Cashier> listFood = new ArrayList<>();
	ArrayList<Cashier> listBeverage = new ArrayList<>();
	ArrayList<Cashier> listOrder = new ArrayList<>();
	
	
	Scanner scanner = new Scanner(System.in);
	
	public Cashier() {
		
	}
		
	public Cashier(String item, int price) {
		super();
		this.item = item;
		this.price = price;
	}

	public Cashier(String item, int price, int quantity) {
		super();
		this.item = item;
		this.price = price;
		this.quantity = quantity;
	}

	
	public String getFood() {
		return food;
	}

	public String getBeverage() {
		return beverage;
	}

	public String getItem() {
		return item;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void order() {
			System.out.print("Apa yang ingin anda pilih? (paket/item) : ");
			ordered = scanner.next();
			if(ordered.toLowerCase().equals("paket")) {
				listOfPack();
				listPack.clear();
				repeatOrder();
			} else if (ordered.toLowerCase().equals("item")) {
				listOfFood();
			} else {
				System.out.println("-- Maaf input yang anda lakukan salah -- ");
				order();
			}
		}
	
	public void repeatOrder() {
		System.out.print("Mau pesan lagi? (y/n) : ");
		String add = scanner.next();
		if (add.toLowerCase().equals("y")) {
			System.out.println();
			order();
		} else if(add.toLowerCase().equals("n")) {
			receiptPembayaran();
		}
	}
	public void listOfPack() {
		listPack.add(new Cashier("PAKET A : Nasi + Ayam Goreng + Tempe/Tahu + Lalapan + Es teh", 20000));
		listPack.add(new Cashier("PAKET B : Nasi + Ayam Bakar + Tempe/Tahu + Lalapan + Es teh", 22500));
		listPack.add(new Cashier("PAKET C : Nasi + Nila Goreng + Tempe/Tahu + Lalapan + Es teh", 25000));
		listPack.add(new Cashier("PAKET D : Nasi + Nila Bakar + Tempe/Tahu + Lalapan + Es teh", 25000));
		
		for (int i = 0 ; i < listPack.size() ; i++) {
			System.out.println((i+1) + ". " + listPack.get(i).getItem() + String.format(" (@ Rp %,d )", listPack.get(i).getPrice()));
		}
		paket();
	}


	public void listOfFood() {
		listFood.add(new Cashier("Nasi", 2000));
		listFood.add(new Cashier("Ayam Goreng", 17500));
		listFood.add(new Cashier("Ayam Bakar", 18500));
		listFood.add(new Cashier("Nila Goreng", 15000));
		listFood.add(new Cashier("Nila Bakar", 16000));
		
		for (int i = 0 ; i < listFood.size() ; i++) {
			System.out.println((i+1) + ". " + listFood.get(i).getItem() + String.format(" (@ Rp %,d )", listFood.get(i).getPrice()));
		}
		makanan();
	}
		
	public void listOfBeverage() {
		listBeverage.add(new Cashier("Air Putih", 1000));
		listBeverage.add(new Cashier("Teh Tawar", 2000));
		listBeverage.add(new Cashier("Teh Manis", 3500));
		listBeverage.add(new Cashier("Es Jeruk", 6000));
		
		for (int i = 0 ; i < listBeverage.size() ; i++) {
			System.out.println((i+1) + ". " + listBeverage.get(i).getItem() + String.format(" (@ Rp %,d )", listBeverage.get(i).getPrice()));
		}
		minuman();
	}
		
	private int orderPack, hargaPaket, amountPack;
	private double totalPrice;
	private String jenisPaket;
	
	public void paket(){
		System.out.print("Pilih paket yang kamu inginkan : ");
		orderPack = scanner.nextInt();
		System.out.print("Jumlah pesanan : ");
		amountPack = scanner.nextInt();
		
		if(orderPack <= listPack.size()) {
			jenisPaket = listPack.get(orderPack-1).getItem();
			hargaPaket = listPack.get(orderPack-1).getPrice();
			
			listOrder.add(new Cashier(jenisPaket, hargaPaket, amountPack));
			totalPrice += (hargaPaket*amountPack);
			
			System.out.println("Paket yang dipilih : " + jenisPaket);
			System.out.println("Total harga : " + String.format( "Rp %,d" , hargaPaket*amountPack));
		}
		
	}
	
	private int orderFood, hargaMakanan, amountFood;
	private String jenisMakanan;
	
	public void makanan() {
		System.out.print("Pilih makanan yang kamu inginkan : ");
		orderFood = scanner.nextInt();
		System.out.print("Jumlah pesanan : ");
		amountFood = scanner.nextInt();
		
		if(orderFood <= listFood.size()) {
			jenisMakanan = listFood.get(orderFood-1).getItem();
			hargaMakanan = listFood.get(orderFood-1).getPrice();
			
			listOrder.add(new Cashier(jenisMakanan, hargaMakanan, amountFood));
			totalPrice += (hargaMakanan*amountFood);
			
			System.out.println("Paket yang dipilih : " + jenisMakanan);
			System.out.println("Total harga : " + String.format( "Rp %,d" , hargaMakanan*amountFood));
		}
		System.out.println();
		addMakanan();
		
	}

	
	public void addMakanan() {
		System.out.print("Apakah anda mau pesan makanan lagi? (y/n) : ");
		String addFood = scanner.next();
		if(addFood.toLowerCase().equals("y")) {
			makanan();
		} else if(addFood.toLowerCase().equals("n")) {
			orderMinuman();
		}
	}
	public void orderMinuman() {
		System.out.println();
		System.out.print("Apakah anda mau pesan minuman? (y/n) : ");
		String orderDrink = scanner.next();
		if(orderDrink.toLowerCase().equals("y")) {
			listOfBeverage();
		} else if(orderDrink.toLowerCase().equals("n")) {
			receiptPembayaran();
		}
	}
	
	private int orderBeverage, hargaMinuman, amountBeverage;
	private String jenisMinuman;
	
	public void minuman() {
		System.out.print("Pilih minuman yang kamu inginkan : ");
		orderBeverage = scanner.nextInt();
		System.out.print("Jumlah pesanan : ");
		amountBeverage = scanner.nextInt();
		
		if(orderBeverage <= listBeverage.size()) {
			jenisMinuman = listBeverage.get(orderBeverage-1).getItem();
			hargaMinuman = listBeverage.get(orderBeverage-1).getPrice();
			
			listOrder.add(new Cashier(jenisMinuman, hargaMinuman, amountBeverage));
			totalPrice += (hargaMinuman*amountBeverage);
			
			System.out.println("Paket yang dipilih : " + jenisMinuman);
			System.out.println("Total harga : " + String.format( "Rp %,d" , hargaMinuman*amountBeverage));
		}
		System.out.println();
		addMinuman();
	}
	
	public void addMinuman() {
		System.out.print("Apakah anda mau pesan minuman lagi? (y/n) : ");
		String addDrink = scanner.next();
		if(addDrink.toLowerCase().equals("y")) {
			minuman();
		} else if(addDrink.toLowerCase().equals("n")) {
			receiptPembayaran();
		}
	}
	
	public void listOfOrder() {
		System.out.println("Pesanan anda\t\t: " + getItem());
		System.out.println("Banyaknya pesanan\t: " + getQuantity() + " porsi");
		System.out.println("Total harga\t\t: " + String.format( "Rp %,d ", (getQuantity()*getPrice())));
		System.out.println();
	}

	private double pajak;
	@Override
	public void receiptPembayaran() {
		// TODO Auto-generated method stub
		
		System.out.println("================================");
		System.out.println("\tNOTA PEMBAYARAN");
		System.out.println("================================");
		
		for (Cashier listPesanan : listOrder) {
			listPesanan.listOfOrder();
		}
		
		pajak = totalPrice*0.1;
		System.out.println("=====================================");
		System.out.println(String.format("Total\t\t\t: Rp %,5.0f " , totalPrice));
		System.out.println(String.format("Pajak (ppn)\t\t: Rp %,5.0f ", pajak));
		System.out.println(String.format("Total Pembayaran\t: Rp %,5.0f ", (totalPrice + pajak))); 
	}
	
}
