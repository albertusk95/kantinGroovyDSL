
class EmailDsl {
	
	def stocks = []
	def menus = []
	def prices = []

	def static access(closure) {
		EmailDsl email = new EmailDsl()
		closure.delegate = email
		closure()
	}

	def add(clo) {
		clo()
	}

	def update(clo) {
		clo()
	}

	def count(clo) {
		clo()
	}

	def calculate(clo) {
		clo()
	}

	def show(clo) {
		clo()
	}

	// add stock
	def stock(List<String> n_stock) {

		showWithNewLine('ADDING STOCKS')
		
		for(int i = 0; i < n_stock.size(); i++) {
			
			stocks << n_stock.get(i).split()[0] + " " + n_stock.get(i).split()[1]
		
			showWithNoNewLine('A total of ')
			showWithNoNewLine(n_stock.get(i).split()[1] + " kg ")
			showWithNoNewLine(n_stock.get(i).split()[0] + " ")
			showWithNewLine("was added")
			
		}

		showWithNewLine('CURRENT STOCKS')
		showWithNewLine(stocks)
		showWithNewLine('')
	
	}

	// add menu
	def menu(List<String> n_menu) {
		
		showWithNewLine('ADDING MENUS')
		
		for(int i = 0; i < n_menu.size(); i++) {
			
			menus << n_menu.get(i).split()[0] + " " + n_menu.get(i).split()[1]
		
			showWithNoNewLine("A total of ")
			showWithNoNewLine(n_menu.get(i).split()[1] + " pcs")
			showWithNoNewLine(n_menu.get(i).split()[0] + " ")
			showWithNewLine("was added")

		}

		showWithNewLine('CURRENT MENUS')
		showWithNewLine(menus)
		showWithNewLine('')
	
	}

	// count the number of stock
	def stock(String n_stock) {
		showWithNewLine("COUNTING THE NUMBER OF A STOCK")

		int totalStock = 0

		for (int i = 0; i < stocks.size(); i++) {
			if (stocks[i].split()[0] == n_stock) {
				totalStock += stocks[i].split()[1].toInteger()
			}
		}

		showWithNoNewLine("Stock: ")
		showWithNewLine(n_stock)
		showWithNoNewLine("Total: ")
		showWithNewLine(totalStock + " kg")
		showWithNewLine("")

	}

	// count the number of menu
	def menu(String n_menu) {
		showWithNewLine("COUNTING THE NUMBER OF A MENU")

		int totalMenu = 0

		for (int i = 0; i < menus.size(); i++) {
			if (menus[i].split()[0] == n_menu) {
				totalMenu += menus[i].split()[1].toInteger()
			}
		}

		showWithNoNewLine("Menu: ")
		showWithNewLine(n_menu)
		showWithNoNewLine("Total: ")
		showWithNewLine(totalMenu + " pcs")
		showWithNewLine("")

	}


	def price(List<String> n_price) {

		showWithNewLine("CALCULATING THE TOTAL PRICE")

		// price (["nasi 1 pcs", "ikan 2pcs", "tempe 2 pcs"])
		int totalPrice = 0
		for (int i = 0; i < n_price.size(); i++) {
			for (int j = 0; j < prices.size(); j++) {
				if (n_price.get(i).split()[0] == prices.get(j).split()[0]) {
					totalPrice += Integer.parseInt(n_price.get(i).split()[1]) * Integer.parseInt(prices.get(j).split()[1])
					break
				} 
			}
		}

		showWithNewLine("Order:")
		showWithNewLine(n_price)
		showWithNewLine("Total price:")
		showWithNoNewLine("Rp ")
		showWithNoNewLine(totalPrice)
		showWithNewLine(",00")
		showWithNewLine("")

	}


	def price(String n_update) {

		showWithNewLine("UPDATING PRICE")
		showWithNewLine(n_update)

		if (prices.size() == 0) {
			prices << n_update
		} else {
			for (int i = 0; i < prices.size(); i++) {
				if (prices.get(i).split()[0] == n_update.split()[0]) {
					prices.set(i, n_update)
				} else {
					if (i == prices.size()-1) {
						prices << n_update
					}
				}
			}
		}

		showWithNewLine("List of prices: ")
		showWithNewLine(prices)
		showWithNewLine("")

	}

	def getStocks() {
		showWithNewLine("FETCHING ALL STOCKS")

		for (int i = 0; i < stocks.size(); i++) {
			showWithNoNewLine(stocks.get(i))
			showWithNewLine(" kg")
		}

		showWithNewLine('')
	}

	def getMenus() {
		showWithNewLine("FETCHING ALL MENUS")

		for (int i = 0; i < menus.size(); i++) {
			showWithNoNewLine(menus.get(i))
			showWithNewLine(" pcs")
		}

		showWithNewLine('')
	}

	// item printer
	def showWithNewLine(item) {
		println item
	}

	def showWithNoNewLine(item) {
		print item
	}

}

EmailDsl.access {
	add {
		stock (["beras 50 kg", "nasi 30 kg", "ayam 10 kg"])
		menu (["ikan_asin 30 pcs", "mie_goreng 10 pcs"])
	}

	update {
		price "nasi 3000"
		price "ikan 8000"
	}

	count {
		stock "beras"
		stock "ayam"
		menu "mie_goreng"
	}

	calculate {
		price (["nasi 1 pcs", "ikan 2 pcs", "tempe 2 pcs"])
	}

	show {
		stocks
		menus
	}

}



/*
KantinDSL.access {

	//please add the stock of beras of 50
	//please(add).the(stock).of(beras).of(50)

	please count the stock of beras
	please count the price of nasi 1 ikan 2 tempe 2
	//please(count).the(stock).of(beras)
	//please(count).the(price).of(nasi(1).ikan(2).tempe(2))

	please show the list of menu
	please show the list of stocks
	//please(show).the(list).of(stocks)
	//please(show).the(list).of(menu)
}
*/

/*
show = { println it }

square_root = { Math.sqrt(it) }

def please(action) {
   [the: {what->
            [of: { number -> action(what(number)) }]
         }
   ]
}

please show the square_root of 100
please show the square_root of 81
please(show).the(square_root).of(36)
*/