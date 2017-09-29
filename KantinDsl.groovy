
class EmailDsl {
	
	def stocks = []
	def menus = []
	def prices = []
	def tables = []
	def incomes = []
	def outcomes = []

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
			showWithNoNewLine(n_menu.get(i).split()[1] + " pcs ")
			showWithNoNewLine(n_menu.get(i).split()[0] + " ")
			showWithNewLine("was added")

		}

		showWithNewLine('CURRENT MENUS')
		showWithNewLine(menus)
		showWithNewLine('')
	
	}

	// add tables 
 	def table(String n_table) { 
        showWithNewLine("ADDING TABLES") 
        
        int tab = 0; 
        tab = Integer.parseInt(n_table) 
        
        for(int i=0;i<tab;i++) { 
            tables<<"available" 
        } 
        
        showWithNoNewLine("There are ") 
        showWithNoNewLine(tab) 
        showWithNewLine(" tables.") 
        showWithNewLine("") 
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

	def order(List<String> n_order) {

		showWithNewLine("ORDERING SOME FOOD")

		for (int i = 0; i < n_order.size(); i++) {
			for (int j = 0; j < menus.size(); j++) {
				if (n_order.get(i).split()[0] == menus.get(j).split()[0]) {
					int amount = n_order.get(i).split()[1].toInteger()
					int remaining = menus.get(j).split()[1].toInteger() - amount

					menus.set(j, n_order.get(i).split()[0] + " " + remaining.toString())

					break
				}
			}
		}

		showWithNoNewLine("Order:")
		showWithNewLine(n_order)

	}

	def income(List<String> n_income) {

		showWithNewLine("ADDING INCOME")

		for (int i = 0; i < n_income.size(); i++) {
			incomes << n_income.get(i)
		}

		showWithNewLine("List of incomes:")
		
		for (int i = 0; i < incomes.size(); i++) {
			showWithNewLine(incomes.get(i))
		}

		showWithNewLine('')

	}

	def outcome(List<String> n_outcome) {

		showWithNewLine("ADDING OUTCOME")

		for (int i = 0; i < n_outcome.size(); i++) {
			outcomes << n_outcome.get(i)
		}

		showWithNewLine("List of outcomes:")
		
		for (int i = 0; i < outcomes.size(); i++) {
			showWithNewLine(outcomes.get(i))
		}

		showWithNewLine('')

	}

	def getTotalIncomes() {

		showWithNewLine("CALCULATING TOTAL INCOMES")

		int incomeValue = 0

		for (int i = 0; i < incomes.size(); i++) {
			incomeValue += incomes.get(i).split()[2]
		}

		showWithNoNewLine("Total incomes:")
		showWithNewLine(incomeValue)

	}

	def getTotalOutcomes() {

		showWithNewLine("CALCULATING TOTAL OUTCOMES")

		int outcomeValue = 0

		for (int i = 0; i < outcomes.size(); i++) {
			outcomeValue += outcomes.get(i).split()[2]
		}

		showWithNoNewLine("Total outcomes:")
		showWithNewLine(outcomeValue)

	}

	// item printer
	def showWithNewLine(item) {
		println item
	}

	def showWithNoNewLine(item) {
		print item
	}

}

// Access the DSL
EmailDsl.access {
	add {
		stock (["beras 50 kg", "nasi 30 kg", "ayam 10 kg"])
		menu (["nasi 10 pcs", "ikan 30 pcs", "mie_goreng 10 pcs"])
		table "50"
		income (["1/01/2017 ikan 20000", "2/01/2017 mie_goreng 50000"])
		outcome (["1/01/2017 pembelian_meja 300000"])
	}

	update {
		price "nasi 3000"
		price "ikan 9000"
		price "mie_goreng 10000"
	}

	count {
		stock "beras"
		stock "ayam"
		menu "mie_goreng"
		menu "ikan"
	}

	calculate {
		price (["nasi 1 pcs", "ikan 2 pcs", "mie_goreng 2 pcs"])
		totalIncomes
		totalOutcomes
	}

	show {
		stocks
		menus
	}

	order (["mie_goreng 2 pcs", "nasi 1 pcs"])

	count {
		menu "mie_goreng"
	}



}
