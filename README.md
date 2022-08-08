# QuickBytesOnSpring
### Kevin
Request/RequestController/RequestRepository
- [x] postRequest()
- [x] getAllRequests()
- [x] getRequest()
- [x] getAllRequestsByRequestId()
- [x] getAllRequestsByVendorId()
- [x] putRequest()
- [x] putRequestPrice()
- [x] pendRequest()
- [x] approveRequest()
- [x] denyRequest()
- [x] putRequestOrderTime()
- [x] putRequestEndTime()
- [x] deleteRequest()
- [x] deleteAllRequestsByCustomerId()
- [x] deleteAllRequestsByVendorId()
- [x] deleteAllRequests()

RequestItem/RequestItemController/RequestItemRepository
- [x] postRequestItem()
- [x] getRequestItem()
- [x] getAllRequestItemsByRequestId()
- [x] getAllRequestItemsByItemId()
- [x] getAllRequestItems()
- [x] putRequestItem()
- [x] deleteRequestItem()
- [x] deleteAllRequestItemsByRequestId()
- [x] deleteAllRequestItemsByItemId()
- [x] deleteAllRequestItems()

RequestCombo/RequestComboController/RequestComboRepository
- [x] postRequestCombo()
- [x] getRequestCombo()
- [x] getAllRequestCombosByRequestId()
- [x] getAllRequestComboByComboId()
- [x] getAllRequestCombos()
- [x] putRequestCombo()
- [x] deleteRequestCombo()
- [x] deleteAllRequestCombosByRequestId()
- [x] deleteAllRequestCombosByComboId()
- [x] deleteAllRequestCombos()

### Jerry
Customer/CustomerController/CustomerRepository
- [x] postCustomer()
- [x] getAllCustomer()
- [x] getCustomerByID()
- [x] deleteCustomerByID() CHECK
- [x] updateCustomerByID() ISSUE #1
- [x] getCustomerByEmployeeID() ISSUE #2
- [x] getCustomerByUsername() CHECK
- [x] getListCustomerWithFirstName()
- [x] getListCustomerWithLastName()
- [x] getListCustomerWithBalanceGreaterThanOrEqual()
- [x] getListCustomerWithBalanceLessThanOrEqual()

Admin/AdminController/AdminRepository
- [x] postAdmin()  CHECK
- [x] getAllAdmins() CHECK
- [x] getAdmin() CHECK
- [x] putAdmin() CHECK
- [x] deleteAdmin() CHECK

UserInfo/UserController/UserRepository
- [x] getUser()
- [x] postUser()
- [x] deleteUser

UserService
- [x] loadUserByUsername()

APISecurityConfig
- [x] getPsswordEncoder()
- [x] configure(HttpSecurity)
- [x] configure(AuthenticationManagerBuilder)
- [x] getCustomerProvider()

Pagination
- [ ] Pending

### James
ItemCombo/ItemComboController/ItemComboRepository
- [x] postItemCombo()
- [x] getItemCombo()
- [x] getAllItemCombosByRequestId()
- [x] getAllItemComboByComboId()
- [x] getAllItemCombos()
- [x] putItemCombo()
- [x] deleteItemCombo()
- [x] deleteAllItemCombosByRequestId()
- [x] deleteAllItemCombosByComboId()
- [x] deleteAllItemCombos()

Item/ItemController/ItemRepository
- [x] postItem()
- [x] getAllItems()
- [x] getSingleItemByID()
- [x] updateItemByID()
