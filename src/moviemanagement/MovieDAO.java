package moviemanagement;

public interface MovieDAO {

	void addMovie(Movie m);
	void viewMovies(int pageNumber, int pageSize);
	void searchMovieByName(String name);
	void updateRating(int id,double rating);
	void sortByRating();
	void sortByName();
	void filterByGenre(String genre);
	void filterByRating(double rating);
	void deleteMovie(int id);
}
