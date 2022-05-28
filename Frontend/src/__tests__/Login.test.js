import React from "react";

import renderer from "react-test-renderer";
import Login from "./../NewUI/Auth/Login";

const mockedUsedNavigate = jest.fn();

jest.mock("react-router-dom", () => ({
  ...jest.requireActual("react-router-dom"),
  useNavigate: () => mockedUsedNavigate,
}));

afterAll(() => {
  jest.clearAllMocks();
});

test("renders correctly", () => {
  const tree = renderer.create(<Login />).toJSON();
  expect(tree).not.toBe(null);
});
