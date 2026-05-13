import React from 'react';


const ProfileCard = ({ player }) => {
return (
    <div className="max-w-md w-full bg-slate-900 text-white rounded-xl overflow-hidden shadow-2xl border border-slate-800">
      <div 
        className="h-32 w-full bg-cover bg-center border-b-2 border-red-500" 
        style={{ backgroundImage: `url(${player.cardUrl})` }}>
      </div>
      
      <div className="p-6 flex items-center justify-between bg-gradient-to-b from-slate-900 to-black">
        <div>
          <h2 className="text-3xl font-bold flex items-baseline gap-2">
            {player.gameName}
            <span className="text-lg text-slate-500 font-normal">#{player.tagLine}</span>
          </h2>
          <p className="text-slate-400 mt-1">Уровень: <span className="text-white font-semibold">{player.accountLevel}</span></p>
        </div>
        
        <div className="flex flex-col items-center">
           <img 
             src={player.rankImageUrl} 
             alt={player.currentRank} 
             className="w-16 h-16 object-contain drop-shadow-md" 
           />
           <p className="text-sm font-bold text-red-500 mt-2 tracking-wide uppercase">
             {player.currentRank}
           </p>
        </div>
      </div>
    </div>
  );
};

export default ProfileCard;