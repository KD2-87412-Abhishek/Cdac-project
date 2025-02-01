import { useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

function UserDashboard() {
  const navigate = useNavigate();

  return (
    <div>
      <h2 className='header'>User  Dashboard</h2>
      <div className='mb-3'>
        <button 
          onClick={() => {
            toast.info('Logging out...');
            // Add your logout logic here
            navigate('/'); // Redirect to HomePage after logout
          }} 
          className='btn btn-danger w-100'
        >
          Logout
        </button>
      </div>
    </div>
  );
}

export default UserDashboard