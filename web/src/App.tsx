import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
// import Result from "./pages/Result";
import Talk from "./pages/Talk";

const App = () => {
  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          {/* <Route path="/result" element={<Result />}></Route> */}
          <Route path="/talk" element={<Talk />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
