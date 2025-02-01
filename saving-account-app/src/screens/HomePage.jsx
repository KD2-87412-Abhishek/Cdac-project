import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';
import './HomePage.css';
import Navbar from '../component/Navbar';

function HomePage() {
  const navigate = useNavigate();

  return (
    <div>
      <Navbar />
      <div className='container '>
        <h2 className='header text-center mb-12'>Welcome to Banking System</h2>
        <div className='row justify-content-center'>
          <div className="col-lg-4 col-md-6 col-sm-12 mb-4">
            <div className="card shadow-lg border-0">
              <div className="card-body text-center">
                <h5 className="card-title">User Login</h5>
                <p className="card-text">Access your account to manage banking services.</p>
                <button 
                  onClick={() => {
                    toast.info('Redirecting to login...');
                    navigate('/login');
                  }} 
                  className='btn btn-custom btn-primary'>
                  Login Now
                </button>
              </div>
            </div>
          </div>

          <div className="col-lg-4 col-md-6 col-sm-12 mb-4">
            <div className="card shadow-lg border-0">
              <div className="card-body text-center">
                <h5 className="card-title">Manager Portal</h5>
                <p className="card-text">Administrative access for bank managers.</p>
                <button 
                  onClick={() => {
                    toast.info('Redirecting to manager login...');
                    navigate('/manager-login');
                  }} 
                  className='btn btn-custom btn-secondary'>
                  Manager Login
                </button>
              </div>
            </div>
          </div>

          <div className="col-lg-4 col-md-6 col-sm-12 mb-4">
            <div className="card shadow-lg border-2">
              <div className="card-body text-center">
                <h5 className="card-title">New User?</h5>
                <p className="card-text">Sign up today to start your banking journey.</p>
                <button 
                  onClick={() => {
                    toast.info('Starting new registration...');
                    navigate('/personal-details');
                  }} 
                  className='btn btn-custom btn-success'>
                  Register Now
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default HomePage;