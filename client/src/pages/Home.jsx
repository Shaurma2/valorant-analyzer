import React, { useState } from 'react';
import { Search } from 'lucide-react';
import ProfileCard from '../components/ProfileCard';
import { mockPlayerProfile } from '../api/mockData';

const Home = () => {
  const [searchInput, setSearchInput] = useState('');
  const [playerData, setPlayerData] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const handleSearch = (e) => {
    e.preventDefault();
    if (!searchInput.trim()) return;
    setIsLoading(true);
    setTimeout(() => {
      setPlayerData(mockPlayerProfile);
      setIsLoading(false);
    }, 800); 
  };

  return (
    <div className="min-h-screen bg-[#0f1923] flex flex-col items-center pt-24 px-4 font-sans text-white relative overflow-hidden">
      
      <div className="absolute top-[-10%] left-[-10%] w-96 h-96 bg-red-500/10 rounded-full blur-3xl pointer-events-none"></div>


      <div className="text-center mb-10 z-10">
        <h1 className="text-5xl md:text-6xl font-black tracking-tighter mb-2">
          VALORANT <span className="text-[#ff4655]">ANALYZER</span>
        </h1>
        <p className="text-slate-400 text-lg">
          Детальная статистика, история матчей и анализ меты
        </p>
      </div>

      <form 
        onSubmit={handleSearch} 
        className="w-full max-w-2xl flex relative z-10 mb-12"
      >
        <div className="relative w-full flex items-center">
          <div className="absolute left-4 text-slate-400">
            <Search size={24} />
          </div>
          <input
            type="text"
            value={searchInput}
            onChange={(e) => setSearchInput(e.target.value)}
            placeholder="Riot ID + Tag (например: TenZ#NA1123)"
            className="w-full bg-slate-900/80 border-2 border-slate-700 focus:border-[#ff4655] rounded-l-lg py-4 pl-12 pr-4 text-lg outline-none transition-colors shadow-lg placeholder:text-slate-500"
          />
        </div>
        <button 
          type="submit"
          className="bg-[#ff4655] hover:bg-[#ff4655]/80 text-white font-bold py-4 px-8 rounded-r-lg transition-colors shadow-lg flex items-center justify-center min-w-[140px]"
        >
          {isLoading ? (
            <span className="animate-pulse">Поиск...</span>
          ) : (
            'Найти'
          )}
        </button>
      </form>

      <div className="z-10 w-full flex justify-center animate-fade-in-up">
        {playerData && <ProfileCard player={playerData} />}
      </div>
      
    </div>
  );
};

export default Home;