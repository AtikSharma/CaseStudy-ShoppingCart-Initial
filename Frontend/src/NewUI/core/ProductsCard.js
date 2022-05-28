import React from "react";
import { children } from "react";
import AllProducts from "./../Product/AllProducts";
import ImageHelper from "./../Product/helper/imageHelper";
import { addItemToCart } from "./../Cart/helper/cartHelper";

const Card = ({ product, children }) => {
  return (
    <div
      className="card text-center shadow-sm h-100 "
      // style={{ width: "15rem"}}
    >
      <div className="card-header ">
        <ImageHelper product={product} />
      </div>

      <ul className="p-0">
        <h5 className="card-title mt-2 fs-5">{product.productName}</h5>
        <div>
          <p className="card-subtitle text-muted  "> {product.productType}</p>
          <p className="card-text fw-bolder">Price: &#x20B9; {product.price}</p>
        </div>
      </ul>
      <div className="p-1 mt-0">{children}</div>
    </div>
  );
};

export default Card;
