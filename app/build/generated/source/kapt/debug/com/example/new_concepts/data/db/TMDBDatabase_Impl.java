package com.example.new_concepts.data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TMDBDatabase_Impl extends TMDBDatabase {
  private volatile MovieDao _movieDao;

  private volatile ArtistDao _artistDao;

  private volatile TvShowsDao _tvShowsDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `popular_movies` (`id` INTEGER NOT NULL, `overview` TEXT, `posterPath` TEXT, `releaseDate` TEXT, `title` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `popular_tvShows` (`id` INTEGER NOT NULL, `firstAirDate` TEXT, `name` TEXT, `overview` TEXT, `posterPath` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `popular_artists` (`id` INTEGER NOT NULL, `name` TEXT, `popularity` REAL, `profilePath` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'cf3df32075659e4aad6c359b9c8470d8')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `popular_movies`");
        _db.execSQL("DROP TABLE IF EXISTS `popular_tvShows`");
        _db.execSQL("DROP TABLE IF EXISTS `popular_artists`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPopularMovies = new HashMap<String, TableInfo.Column>(5);
        _columnsPopularMovies.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPopularMovies.put("overview", new TableInfo.Column("overview", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPopularMovies.put("posterPath", new TableInfo.Column("posterPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPopularMovies.put("releaseDate", new TableInfo.Column("releaseDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPopularMovies.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPopularMovies = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPopularMovies = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPopularMovies = new TableInfo("popular_movies", _columnsPopularMovies, _foreignKeysPopularMovies, _indicesPopularMovies);
        final TableInfo _existingPopularMovies = TableInfo.read(_db, "popular_movies");
        if (! _infoPopularMovies.equals(_existingPopularMovies)) {
          return new RoomOpenHelper.ValidationResult(false, "popular_movies(com.example.new_concepts.data.model.movie.Movie).\n"
                  + " Expected:\n" + _infoPopularMovies + "\n"
                  + " Found:\n" + _existingPopularMovies);
        }
        final HashMap<String, TableInfo.Column> _columnsPopularTvShows = new HashMap<String, TableInfo.Column>(5);
        _columnsPopularTvShows.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPopularTvShows.put("firstAirDate", new TableInfo.Column("firstAirDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPopularTvShows.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPopularTvShows.put("overview", new TableInfo.Column("overview", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPopularTvShows.put("posterPath", new TableInfo.Column("posterPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPopularTvShows = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPopularTvShows = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPopularTvShows = new TableInfo("popular_tvShows", _columnsPopularTvShows, _foreignKeysPopularTvShows, _indicesPopularTvShows);
        final TableInfo _existingPopularTvShows = TableInfo.read(_db, "popular_tvShows");
        if (! _infoPopularTvShows.equals(_existingPopularTvShows)) {
          return new RoomOpenHelper.ValidationResult(false, "popular_tvShows(com.example.new_concepts.data.model.tvshow.TvShow).\n"
                  + " Expected:\n" + _infoPopularTvShows + "\n"
                  + " Found:\n" + _existingPopularTvShows);
        }
        final HashMap<String, TableInfo.Column> _columnsPopularArtists = new HashMap<String, TableInfo.Column>(4);
        _columnsPopularArtists.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPopularArtists.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPopularArtists.put("popularity", new TableInfo.Column("popularity", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPopularArtists.put("profilePath", new TableInfo.Column("profilePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPopularArtists = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPopularArtists = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPopularArtists = new TableInfo("popular_artists", _columnsPopularArtists, _foreignKeysPopularArtists, _indicesPopularArtists);
        final TableInfo _existingPopularArtists = TableInfo.read(_db, "popular_artists");
        if (! _infoPopularArtists.equals(_existingPopularArtists)) {
          return new RoomOpenHelper.ValidationResult(false, "popular_artists(com.example.new_concepts.data.model.artist.Artist).\n"
                  + " Expected:\n" + _infoPopularArtists + "\n"
                  + " Found:\n" + _existingPopularArtists);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "cf3df32075659e4aad6c359b9c8470d8", "0d0e66cfcb1f86f022cb6ca343854e87");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "popular_movies","popular_tvShows","popular_artists");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `popular_movies`");
      _db.execSQL("DELETE FROM `popular_tvShows`");
      _db.execSQL("DELETE FROM `popular_artists`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MovieDao.class, MovieDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ArtistDao.class, ArtistDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TvShowsDao.class, TvShowsDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public MovieDao movieDao() {
    if (_movieDao != null) {
      return _movieDao;
    } else {
      synchronized(this) {
        if(_movieDao == null) {
          _movieDao = new MovieDao_Impl(this);
        }
        return _movieDao;
      }
    }
  }

  @Override
  public ArtistDao artistDao() {
    if (_artistDao != null) {
      return _artistDao;
    } else {
      synchronized(this) {
        if(_artistDao == null) {
          _artistDao = new ArtistDao_Impl(this);
        }
        return _artistDao;
      }
    }
  }

  @Override
  public TvShowsDao tvDao() {
    if (_tvShowsDao != null) {
      return _tvShowsDao;
    } else {
      synchronized(this) {
        if(_tvShowsDao == null) {
          _tvShowsDao = new TvShowsDao_Impl(this);
        }
        return _tvShowsDao;
      }
    }
  }
}
