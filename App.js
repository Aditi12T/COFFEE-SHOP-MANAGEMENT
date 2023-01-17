import Home from "./Home";
import Login from "./Login";
import SignUp from "./SignUp";
import Product from "./components/Product";
import Customer from "./components/Customer";
import UpdateCustomer from "./components/UpdateCustomer"

import AddProduct from "./components/AddProduct";
//import ProductById from "./ProductById";
import {Routes, Route, BrowserRouter} from 'react-router-dom';
import UpdateProduct from "./components/UpdateProduct";


function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="" element={<Login/>}></Route>
          <Route path="/signup" element={<SignUp/>}></Route>
          <Route path="/login" element={<Login/>}></Route>
          <Route path="/home" element={<Home/>}></Route>
          <Route path="/product" element={<Product/>}></Route>
          <Route path="/customer" element={<Customer/>}></Route>
          <Route path="/updatecustomer" element={<Customer/>}></Route>
          <Route path="/deletecustomer" element={<Customer/>}></Route>
          <Route path="/add" element={<AddProduct/>}></Route>
          <Route path="/update" element={<UpdateProduct/>}></Route>

          </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;