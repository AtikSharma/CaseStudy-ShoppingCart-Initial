import React, { useState, useEffect } from "react";
import Product from "./Product";
import axios from "axios";
import { toast } from "react-toastify";
import Base from "../core/Base";
import { checkAuthentication } from "./../Auth/helper/authHelper";
import api from "./../api/webapi";
import {
  getAllProductFromServer,
  getAllCategories,
  getProductByCategory,
} from "./helper/updateHelper";

function AllProducts() {
  const [Products, setProducts] = useState([]);
  const [Categories, setCategories] = useState({});

  const getProducts = async () => {
    let res = await getAllProductFromServer();
    setProducts(res.data);
  };

  const getCategories = async () => {
    let res = await getAllCategories();
    setCategories(res.data);
  };

  const selectCategory = async (name) => {
    let res = await getProductByCategory(name);
    setProducts(res.data);
  };

  useEffect(() => {
    getProducts();
    getCategories();
    document.title = "Manage Products";
  }, []);

  const removeProductById = (id) => {
    setProducts(Products.filter((c) => c.productId !== id));
  };

  return (
    <Base
      title="Manage Products"
      description="Update product details or delete them"
    >
      <div class="row">
        <div className="col-2">
          <div class="list-group">
            <div
              class="list-group-item list-group-item  text-light"
              style={{ backgroundColor: "#BB9981" }}
            >
              Categories
            </div>
            {Categories.length > 0 && (
              <div
                class="list-group-item list-group-item-action "
                onClick={() => {
                  getProducts();
                }}
              >
                All Categories
              </div>
            )}
            {Categories.length > 0 ? (
              Categories.map((category) => (
                <div
                  class="list-group-item list-group-item-action "
                  aria-current="true"
                  key={category.categoryId}
                  onClick={() => {
                    selectCategory(category.categoryName);
                  }}
                >
                  {category.categoryName}
                </div>
              ))
            ) : (
              <div class="list-group-item list-group-item ">No Category</div>
            )}
          </div>
        </div>
        <div class="col">
          <div
            class="row row-cols-1 row-cols-md-5 g-2 "
            data-testid="productsList"
          >
            {Products.length > 0 ? (
              Products.map((product) => (
                <Product
                  key={product.productId}
                  product={product}
                  update={removeProductById}
                  adminButtons={true}
                  addtoCartButton={false}
                />
              ))
            ) : (
              <div
                class="alert alert-warning m-auto w-50 text-center shadow mt-1"
                role="alert"
              >
                No Products Found
              </div>
            )}
          </div>
        </div>
      </div>
    </Base>
  );
}

export default AllProducts;
