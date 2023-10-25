import sqlite3
#https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/ use java to connect to sqlite directly

conn = sqlite3.connect('test.db')

print("Opened database successfully")

# conn.execute('''CREATE TABLE COMPANY
#          (ID INT PRIMARY KEY     NOT NULL,
#          NAME           TEXT    NOT NULL,
#          AGE            INT     NOT NULL,
#          ADDRESS        CHAR(50),
#          SALARY         REAL);''')
# print("Table created successfully")

conn.execute("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) \
      VALUES (1, 'Paul', 32, 'California', 20000.00 )")

conn.execute("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) \
      VALUES (2, 'Allen', 25, 'Texas', 15000.00 )")

conn.execute("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) \
      VALUES (3, 'Teddy', 23, 'Norway', 20000.00 )")

conn.execute("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) \
      VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 )")

conn.commit()
print("Records created successfully")
conn.close()
# CREATE
def Create(selection, origin, condition):
    query = "SELECT xxx FROM xxx WHERE xxx"
    conn = sqlite3.connect('test.db')
    return conn.execute(query)
      
def createTempOrder():
      return pass
def createConfirmedOrder():
      return pass
def createNewCustomer():
      return pass
# Extra def createAmendment():

# READ
def Read(query):
    query = "SELECT xxx FROM xxx WHERE xxx"
    conn = sqlite3.connect('test.db')
    return conn.execute(query)

def getCategories():
      # return dictionary with category name as key, and their category item as list value
      return pass
def getProductData():
      return pass
def getProductSides():
      return pass
def getOrderData():
      return pass
def getTempOrderData():
      return pass
def getCustomerData():
      return pass
def getAmendments():
      return pass
def getOrderHistory(dateRange):
      return pass
def getExistCaller(phoneNumber):
      # return boolean if exist
      return pass
      
# UPDATE
def Update(query):
    conn = sqlite3.connect('test.db')
    return conn.execute(query)

def updateTemporaryOrder(newTempData):
      return pass
def updateConfirmedOrder(newConfData):
      return pass
def updateCustomer():
      return pass
def updateTempToConfirmed(orderID):
      return pass
      
# DELETE
def Delete(query):
    conn = sqlite3.connect('test.db')
    return conn.execute(query)

def deleteTempOrder():
      return pass
def deleteConfOrder():
      return pass
def deleteTempOrderData():
      return pass
def deleteConfOrderData():
      return pass
def deleteCustomer():
      return pass

# simplify queries into actual valid/common operations
# specific method to fetch product information
# method to fetch customer information
# method to update customer information
# method to fetch sales for today or other dates
# method to update existing product information
# method to add new product information
# when fetching product information that includes price, check if online platform or not, then fetch different price
