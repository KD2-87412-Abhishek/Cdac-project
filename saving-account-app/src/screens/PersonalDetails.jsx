import { useNavigate } from 'react-router-dom';
import { useState } from 'react';
import { toast } from 'react-toastify';
import Navbar from '../component/Navbar';


function PersonalDetails() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    gender: '',
    dateOfBirth: '',
    email: '',
    maritalStatus: '',
    address: '',
    city: '',
    state: ''
    
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    toast.info('Saving personal details...');
    setTimeout(() => {
      navigate('/additional-details'); // Redirect with a delay
    }, 1000);
  };

  return (
    <div>
      <Navbar />
      <div className="container-fluid" style={{ paddingTop: '80px' }}>
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className='card'>
            <div className='card-body'>
              <h3 className='text-center mb-4'>Personal Details</h3>
              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                  <label htmlFor="firstName">First Name</label>
                  <input
                    onChange={handleChange}
                    type="text"
                    className="form-control"
                    name="firstName"
                    value={formData.firstName}
                    required
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="lastName">Last Name</label>
                  <input
                    onChange={handleChange}
                    type="text"
                    className="form-control"
                    name="lastName"
                    value={formData.lastName}
                    required
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="gender">Gender</label>
                  <select
                    onChange={handleChange}
                    className="form-select"
                    name="gender"
                    value={formData.gender}
                    required
                  >
                    <option value="">Select Gender</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="other">Other</option>
                  </select>
                </div>
                <div className="mb-3">
                  <label htmlFor="dateOfBirth">Date of Birth</label>
                  <input
                    onChange={handleChange}
                    type="date"
                    className="form-control"
                    name="dateOfBirth"
                    value={formData.dateOfBirth}
                    required
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="email">Email</label>
                  <input
                    onChange={handleChange}
                    type="email"
                    className="form-control"
                    name="email"
                    value={formData.email}
                    required
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="maritalStatus">Marital Status</label>
                  <select
                    onChange={handleChange}
                    className="form-select"
                    name="maritalStatus"
                    value={formData.maritalStatus}
                    required
                  >
                    <option value="">Select Marital Status</option>
                    <option value="single">Single</option>
                    <option value="married">Married</option>
                    <option value="divorced">Divorced</option>
                    <option value="widowed">Widowed</option>
                  </select>
                </div>
                <div className="mb-3">
                  <label htmlFor="address">Address</label>
                  <input
                    onChange={handleChange}
                    type="text"
                    className="form-control"
                    name="address"
                    value={formData.address}
                    required
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="city">City</label>
                  <input
                    onChange={handleChange}
                    type="text"
                    className="form-control"
                    name="city"
                    value={formData.city}
                    required
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="state">State</label>
                  <input
                    onChange={handleChange}
                    type="text"
                    className="form-control"
                    name="state"
                    value={formData.state}
                    required
                  />
                </div>
               
                <button type="submit" className="btn btn-primary w-100">
                  Submit
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
      </div>
    </div>
  );
}

export default PersonalDetails;
