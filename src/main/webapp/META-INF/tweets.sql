CREATE TABLE tweets (                
    id INT AUTO_INCREMENT PRIMARY KEY,                
    content TEXT NOT NULL,                
    posted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                
    author VARCHAR(255) NOT NULL                
);                


INSERT INTO tweets (countent, author) VALUES 
    ('今日はいい天気ですね。', 'user1'),
    ('新しい本を読みました。面白かったです。', 'user2'),
    ('昨日の夜は友達と食事に行きました。', 'user3'), 
    ('最近、忙しくて疲れています。', 'user4'),
    ('おはようございます！', 'user5');
