import React from "react";

import renderer from "react-test-renderer";

import Dashboard from './../NewUI/DashBoards/Dashboard';

afterAll(() => {
  jest.clearAllMocks();
});

test("renders correctly", () => {
  const tree = renderer.create(<Dashboard/>).toJSON();
  expect(tree).toMatchSnapshot();
});
