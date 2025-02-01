import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Services from './screens/Services.jsx';



// Auth Pages

import HomePage from './screens/HomePage.jsx';
import Login from './screens/Login.jsx';
import PersonalDetails from './screens/PersonalDetails.jsx';
import AdditionalDetails from './screens/AdditionalDetails';
import ManagerLogin from './screens/Managerlogin.jsx';
import '../src/styles/Layout.css';

function App() {
  return (
    <div className="app">
        <div className="content">
      <ToastContainer />
      <Routes>

        {/* Authentication Routes */}
        <Route path='/' element={< HomePage/>} />
        <Route path='login' element={<Login />} />
        <Route path='Services' element={<Services />} />

        <Route path='manager-login' element={<ManagerLogin />} />
        <Route path='personal-details' element={<PersonalDetails />} />
        <Route path='additional-details' element={<AdditionalDetails />} />
      </Routes>
      </div>
      </div>
  
  );
}

export default App;