import renderer from "react-test-renderer";
import Product from "./../NewUI/Product/Product";
import { render, screen } from "@testing-library/react";

const product = {
  productId: "pid1",
  productName: "ProductName",
  image: "Schwartz",
  price: 20,
};

test("Check Conditional Rendering of Product Buttons", () => {
  const { getByText } = render(
    <Product product={product} addtoCartButton={true}></Product>
  );
  expect(screen.getByText(/Add To/i)).toBeTruthy();
});

test("Check Conditional Rendering of Addtocart button", () => {
  const { queryByText } = render(
    <Product product={product} addtoCartButton={false}></Product>
  );
  expect(screen.queryByText(/Add To/i)).toBeFalsy();
});
