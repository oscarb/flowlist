# Model

Entities and relationships that makes Flowlist

## User
- Id 
- Hashed phone number

When choosing a user to send a link to, each user should appear as they do in the sharing user's phonebook. As few personal details as possible should be stored on the server to respect the users privacy.

## Share
- Timestamp
- FromUser
- ToUsers
- Link

## Reaction
- Timestamp
- Emoiji
- ByUser
- Share

## Link
- URL
- Title
- Duration
- SuggestedType (watch, listen, read)

Before any link is saved, the URL should be normalized. Duration is implemented differently for each subclass.

### VideoLink
- Thumbnail

#### YouTubeLink
- YouTubeId

### AudioLink
- Artist
- Title
- Type (Album, track...)

#### SpotifyLink
- SpotifyId

### ArticleLink
- Author
