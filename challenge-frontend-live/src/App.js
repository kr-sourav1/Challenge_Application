import { useEffect, useState } from 'react';
import './App.css';
import ChallengeList from './Components/ChallengeList';
import axios from 'axios';
import AddChallenge from './Components/AddChallenge';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [challenges, setChallenges] = useState([]);

  useEffect(() => {
    fetchChallenges();
  }, []);

  const fetchChallenges = async () => {
    try{
      const response = await axios.get('http://challenge-application-env.eba-c2aypjrk.eu-north-1.elasticbeanstalk.com/challenges');
      setChallenges(response.data);
    }catch (error){
      console.error("Error fetching challenges: ", error);
    }
    
  };

  const handleChallengeAdded = () => {
    fetchChallenges();
  }

  return (
    <div className="container mt-5">
      <h1 className='text-center mb-4'>Monthly Challenges</h1>
      <AddChallenge onChallengeAdded={handleChallengeAdded}/>
      <ChallengeList challenges={challenges}/>
    </div>
  );
}

export default App;
