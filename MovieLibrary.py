
# Global movie_list variable
movie_list = []

# Global menu prompt string
menu_prompt = """\nPlease enter 'a' to add a movie to collection, 
            \n'l' to list all movies in collection, 
            \n'f' to search for a movie in the collection, 
            \nor 'q' to quit: """
            
# Add new movies to my collection
def addMovie(movie_list):
    title = input("Enter the movie title: ")
    director = input("Enter the movie director: ")
    year = input("Enter the movie release year: ")

    movie_list.append({
        'title': title, 
        'director': director, 
        'year': year
    })

# List all Movies in my collectiong
def listMovies(movie_list):
    [printMovie(movie)for movie in movie_list]
         

# Find movie using movie title(search)
def findMovie(movie_list):
    user = input("\nPlease enter property to search for, 't' for title, 'd' for director, or 'y' for year: ")
    if user == 't':
        user = input("\nPlease enter movie title: ")
        [printMovie(movie) for movie in movie_list if movie["title"] == user]
    elif user == 'd':
        user = input("\nPlease enter movie director: ")
        [printMovie(movie) for movie in movie_list if movie["director"] == user]
    elif user == 'y':
        user = input("\nPlease enter movie year: ")
        [printMovie(movie) for movie in movie_list if movie["year"] == user]

# Prints Movies in nice format
def printMovie(movie):
    print(f"Title: {movie['title']}")
    print(f"Director: {movie['director']}")
    print(f"Year: {movie['year']}\n")
            
# Global user options for menu
user_options = {
    "a": addMovie,
    "l": listMovies,
    "f": findMovie
}

# Main Method
if __name__ == "__main__":
    user = input(menu_prompt)
    while user != 'q':
        if user in user_options:
            selected_function = user_options[user]
            selected_function(movie_list)
        else:
            print("Unknown command used. Please enter a proper command.")
        user = input(menu_prompt)
