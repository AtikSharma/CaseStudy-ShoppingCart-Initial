import React, { useEffect, useState } from "react";
import {
  BrowserRouter,
  Routes,
  Route,
  Navigate,
  Outlet,
} from "react-router-dom";
import AllProducts from "./NewUI/Product/AllProducts";
import AddProduct from "./NewUI/Product/AddProduct";
import Login from "./NewUI/Auth/Login";
import Home from "./NewUI/core/Home";
import Menu from "./NewUI/core/Menu";
import Register from "./NewUI/Auth/Register";
import { ToastContainer, toast } from "react-toastify";
import UpdateProduct from "./NewUI/Product/UpdateProduct";
import Dashboard from "./NewUI/DashBoards/Dashboard";
import AllUsers from "./NewUI/User/AllUsers";
import AddCategory from "./NewUI/Category/AddCategory";
import AllCategory from "./NewUI/Category/AllCategory";
import UpdateCategory from "./NewUI/Category/UpdateCategory";
import Cart from "./NewUI/Cart/Cart";
import AllOrders from "./NewUI/Order/AllOrders";

import {
  checkAuthentication,
  ProtectedRoute,
} from "./NewUI/Auth/helper/authHelper";
import Success from "./NewUI/Payment/Success";
import Failure from "./NewUI/Payment/Failure";
import Checkout from "./NewUI/Payment/Checkout";
import CustomerTransaction from './NewUI/Transactions/CustomerTransaction';

const Renderer = () => {
  return (
    <BrowserRouter>
      <ToastContainer />
      <Menu />

      <Routes>
        {/* Public Routes */}
        <Route path="/" element={<Home />} exact />
        <Route path="/login" element={<Login />} exact />
        <Route path="/register" element={<Register />} exact />
        <Route path="/profile" element={<Dashboard />} exact />

        {/* Customer Routes */}
        <Route element={<ProtectedRoute allowedRole={"Customer"} />}>
          <Route path="/cart" element={<Cart />} exact />
          <Route path="/orders" element={<AllOrders />} exact />
          <Route path="/payment/success" element={<Success />} exact />
          <Route path="/payment/failure" element={<Failure />} exact />
          <Route path="/checkout" element={<Checkout />} exact />
          <Route path="/transactions" element={<CustomerTransaction />} exact />
        </Route>

        {/* Merchant Routes */}
        <Route
          element={
            <ProtectedRoute
              userRole={checkAuthentication().role}
              allowedRole={"Merchant"}
            />
          }
        >
          <Route path="/manageProducts" element={<AllProducts />} exact />
          <Route path="/addProduct" element={<AddProduct />} exact />
          <Route path="/updateProduct" element={<UpdateProduct />} exact />
          <Route path="/users" element={<AllUsers />} exact />
          <Route path="/addCategory" element={<AddCategory />} exact />
          <Route path="/manageCategories" element={<AllCategory />} exact />
          <Route path="/updateCategory" element={<UpdateCategory />} exact />
        </Route>
      </Routes>
    </BrowserRouter>
  );
};

export default Renderer;
