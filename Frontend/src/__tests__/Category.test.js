import axios from "axios";
import { addCategory } from "./../NewUI/Category/helper/categoryApiCall";

jest.mock("axios");

it("addCategory", async () => {
  const api = "http://localhost:9999";
  const category = { categoryName: "newCategory" };
  const response = { categoryName: "newCategory", categoryId: "123agfaisgfas" };
  axios.post.mockImplementation(() => response);

  const result = await addCategory(category);

  expect(axios.post).toHaveBeenCalledWith(
    `${api}/category/addCategory`,
    category
  );
  expect(result).toEqual(response);
});
