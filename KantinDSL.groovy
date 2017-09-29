
class KantinDsl {
	
	def stocks = []
	def menus = []
	def prices = []
	def tables = []
	def recipes = [:]
	def incomes = []
	def outcomes = []

	def static access(closure) {
		KantinDsl kantin = new KantinDsl()
		closure.delegate = kantin
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

		showWithNewLine('')

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
			incomeValue += incomes.get(i).split()[2].toInteger()
		}

		showWithNoNewLine("Total incomes:")
		showWithNewLine(incomeValue)

		showWithNewLine('')

	}

	def getTotalOutcomes() {

		showWithNewLine("CALCULATING TOTAL OUTCOMES")

		int outcomeValue = 0

		for (int i = 0; i < outcomes.size(); i++) {
			outcomeValue += outcomes.get(i).split()[2].toInteger()
		}

		showWithNoNewLine("Total outcomes:")
		showWithNewLine(outcomeValue)

		showWithNewLine('')

	}

	def getIncomes() {

		showWithNewLine("FETCHING LIST OF INCOMES")

		for (int i = 0; i < incomes.size(); i++) {
			showWithNewLine(incomes.get(i))
		}

		showWithNewLine('')

	}

	def getOutcomes() {

		showWithNewLine("FETCHING LIST OF OUTCOMES")

		for (int i = 0; i < outcomes.size(); i++) {
			showWithNewLine(outcomes.get(i))
		}

		showWithNewLine('')

	}

	def dineIn(String n_dineIn) {
		
		showWithNewLine("RESERVING SEAT FOR DINING IN")

		int numOfTable = n_dineIn.split()[0].toInteger()
		
		int availableTables = 0
		def listOfTableIdx = []

		for (int i = 0; i < tables.size(); i++) {
			if (tables.get(i) == "available") {
				availableTables += 1
				listOfTableIdx << i
			}
		}

		int remainingTable = availableTables - numOfTable

		if (availableTables >= numOfTable) {

			int counter2 = 0

			for (int i = 0; i < availableTables; i++) {
				if (counter2 < numOfTable) {
					counter2 += 1
					tables.set(listOfTableIdx[i], "not_available")
				} else {
					break
				}
			}

			showWithNewLine("Reserved tables:")
			showWithNewLine(n_dineIn)
			showWithNewLine("Available tables:")
			showWithNoNewLine(remainingTable)
			showWithNewLine(" meja")

		} else {
			showWithNewLine("Could not find enough tables")
		}

		showWithNewLine("")

	}

	def cleanUp(String n_cleanUp) {

		showWithNewLine("CLEANING UP TABLES")

		int numOfTableToCleanUp = n_cleanUp.split()[0].toInteger()
		int availTables = 0

		for (int i = 0; i < tables.size(); i++) {
			if (tables.get(i) == "available") {
				availTables += 1
			}
		}

		int availableTable = availTables + numOfTableToCleanUp
		int counter = 0

		for (int i = 0; i < tables.size(); i++) {
			if (tables.get(i) == "not_available") {
				if (counter < numOfTableToCleanUp) {
					counter += 1
					tables.set(i, "available")
				}
			}
		}

		showWithNewLine("Cleaned up tables:")
		showWithNewLine(numOfTableToCleanUp)
		showWithNewLine("Available tables:")
		showWithNoNewLine(availableTable)
		showWithNewLine(" meja")
		showWithNewLine("")

	}

	def recipe(List<String> n_recipe) { 
        showWithNewLine("ADDING RECIPES") 
        
        for(int i=0;i<n_recipe.size();i++) { 
            String key = n_recipe.get(i).split(" uses ")[0] 
            String igds = n_recipe.get(i).split(" uses ")[1] 
            String[] igd = igds.split(",") 
            recipes.put(key, igd) 
            showWithNoNewLine("A recipe for ") 
            showWithNoNewLine(key + ": ") 
            showWithNoNewLine(igds) 
            showWithNewLine(" was added") 
        } 
        
        showWithNewLine('CURRENT RECIPES') 
        showWithNewLine(recipes) 
        showWithNewLine('') 
    } 


	def cook(List<String> n_cook) { 
        showWithNewLine("COOKING FOODS") 

        def availToCook = [] 
        
        for(int i=0;i<n_cook.size();i++) { 
            def resep = recipes.get(n_cook.get(i).split()[0]) 
            if(resep != null) { 
                /*boolean isBahanAvail = true, isBahanSufficient = true; 
                for(int i=0;i<resep.size()&&isBahanAvail;i++) { 
                    String bahan = resep.get(i).split()[0] 
                    int qty = Integer.parseInt(resep.get(i).split()[1]) 
                    for(int j=0;j<stocks.size()&&isBahanSufficient;j++) { 
                        String stok = stocks.get(i).split()[0] 
                        if(bahan == stok) { 
                            int qtyav = Integer.parseInt (stocks.get(i).split()[1]) 
                        } 
                    } 
                }*/ 
                availToCook<<n_cook.get(i) 
            } 
            else { 
                showWithNewLine("Menu " + n_cook.get(i).split()[0] + " tidak ada di resep!") 
            } 
        }

        boolean isInMenu = false; 
        
        for(int i=0;i<availToCook.size();i++) { 
            isInMenu = false; 
            for(int j=0;j<menus.size()&&!isInMenu;j++) { 
                if(availToCook.get(i).split()[0] == menus.get(j).split()[0]) { 
                    isInMenu = true; 
                    int total = Integer.parseInt(menus.get(j).split()[1]) + Integer.parseInt(availToCook.get(i).split()[1]) 
                    String res = menus.get(j).split()[0] + " " + total 
                    menus.set(j, res) 
                } 
            } 
            if(!isInMenu) { 
                menus<<availToCook.get(i).split()[0] + " " + availToCook.get(i).split()[1] 
            } 
            showWithNoNewLine("A total of ") 
            showWithNoNewLine(availToCook.get(i).split()[1] + " pcs ") 
            showWithNoNewLine(availToCook.get(i).split()[0] + " ") 
            showWithNewLine("was cooked") 
        } 

        showWithNewLine('CURRENT MENUS') 
        showWithNewLine(menus) 
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

// Access the DSL
KantinDsl.access {
	add {
		stock (["beras 50 kg", "nasi 30 kg", "ayam 10 kg"])
		menu (["nasi 10 pcs", "ikan 30 pcs", "mie_goreng 10 pcs"])
		table "50"
		income (["1/01/2017 ikan 20000", "2/01/2017 mie_goreng 50000"])
		outcome (["1/01/2017 pembelian_meja 300000"])
		recipe (["ikan_asin uses ikan 2,garam 1"])
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
	}

 	cook (["mie_goreng 3 pcs", "ikan_asin 2 pcs"]) 

	show {
		stocks
		menus
		incomes
		outcomes
		totalIncomes
		totalOutcomes
	}

	order (["mie_goreng 2 pcs", "nasi 1 pcs"])

	count {
		menu "mie_goreng"
	}

	dineIn "5 meja"

	cleanUp "3 meja"

}
