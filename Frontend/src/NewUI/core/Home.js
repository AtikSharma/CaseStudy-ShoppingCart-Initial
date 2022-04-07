import React, { useState, useEffect } from "react";
import "../styles.css";
import Base from "./Base";
import Product from "./../Product/Product";
import {
  getAllProductFromServer,
  getAllCategories,
  getProductByCategory,
} from "../Product/helper/updateHelper";

export default function Home() {
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
    document.title = "Welcome | Home";
  }, []);

  return (
    <Base
      title="Shopping Buddy"
      description="Your one stop for all kinds of products"
    >
      <div>
        <div>
          <div class="row">
            <div className="col-2">
              <div class="list-group shadow-sm">
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
                  <div class="list-group-item list-group-item ">
                    No Category
                  </div>
                )}
              </div>
            </div>
            <div className="col">
              <div class="row row-cols-1 row-cols-md-5 g-2 ">
                {Products.length > 0
                  ? Products.map((product) => (
                      <Product
                        key={product.productId}
                        product={product}
                        addtoCartButton={true}
                      />
                    ))
                  :  <div
                  class="alert alert-warning m-auto w-50 text-center shadow mt-1"
                  role="alert"
                >
                  No Products Found
                </div>}
              </div>
            </div>
          </div>
        </div>
      </div>
    </Base>
  );
}
