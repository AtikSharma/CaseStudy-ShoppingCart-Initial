import axios from "axios";
import { fetchData } from "../TestComponent";
import  renderer  from 'react-test-renderer';
import TestComponent from './../TestComponent';

jest.mock("axios");

describe("Axios Get Api Mocking", () => {

    it("fetching list ", async () => {
      const items = [
        {
          userId: "id_1",
          id: "1",
          body: "bodyyyyy1",
          title: "title1",
        },
        {
            userId: "id_3",
            id: "2",
            body: "bodyyyyy2",
            title: "title2",
        },
      ];
  
      const resp = { data: items };
  
      axios.get.mockImplementation(() => Promise.resolve(resp));
  
      await fetchData((res) => expect(res.data).toEqual(items));
    });

    it("Checking Component Rendering ",() => {
        const tree = renderer.create(<TestComponent />).toJSON();
        expect(tree).not.toBe(null);
    })
  

  });
  