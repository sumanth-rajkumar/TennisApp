import React, { useState } from 'react';

const Search = () => {
    const [suffix, setSuffix] = useState('');
    const [results, setResults] = useState([]);

    const handleSearch = () => {
        fetch(`/search?suffix=${suffix}`)
            .then(response => response.json())
            .then(data => {
                setResults(data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    };

    return (
        <div>
            <h1>Tennis Player Search</h1>
            <input
                type="text"
                value={suffix}
                onChange={(e) => setSuffix(e.target.value)}
                placeholder="Search by suffix"
            />
            <button onClick={handleSearch}>Search</button>
            <ul>
                {results.map((player, index) => (
                    <li key={index}>{player.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default Search;
