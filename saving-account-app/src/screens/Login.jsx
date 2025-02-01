import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import Navbar from '../component/Navbar';

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = () => {
    toast.info('Logging in...');
    // Add your login logic here
    navigate('/user-dashboard'); // Redirect to User Dashboard after login
  };

  return (
   
   <div>
    <Navbar/>
    <div className="row justify-content-center">
        <div className="col-md-4">
          
            <div className='card'>
              <div className='card-body'>
                <h3 className='text-center mb-4'>user-Login</h3>
          <label htmlFor="email">Email</label>
          <input
            type="email"
            className="form-control form-control-sm"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <div className="mb-4">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            className="form-control form-control-sm"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
        <button 
          onClick={handleLogin} 
          className="btn btn-primary w-100"
        >
          Login
        </button>
      </div>
    </div>
    </div>
    </div>
  );
}

export default Login;
